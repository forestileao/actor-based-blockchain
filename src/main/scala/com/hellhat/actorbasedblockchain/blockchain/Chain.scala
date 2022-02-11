package com.hellhat.actorbasedblockchain.blockchain

import spray.json.*
import com.hellhat.actorbasedblockchain.blockchain.utils.JsonSupport._
import com.hellhat.actorbasedblockchain.crypto.Crypto

import java.security.InvalidParameterException

sealed trait Chain {
  val index: Int
  val hash: String
  val values: List[Transaction]
  val proof: Long
  val timestamp: Long

  def ::(link: Chain): Chain = link match {
    case l: ChainLink => ChainLink(l.index, l.proof, l.values, this.hash, this)
    case _ => throw new InvalidParameterException("Cannot add invalid link to chain")
  }
}

object Chain {
  def apply[T](blocks: Chain*): Chain = {
    if blocks.isEmpty then EmptyChain
    else
      val link = blocks.head.asInstanceOf[ChainLink]
      ChainLink(link.index, link.proof, link.values, link.previousHash, Chain(blocks.tail: _*))
  }
}

case object EmptyChain extends Chain {
  val index = 0
  val hash = "1"
  val values = Nil
  val proof = 100L
  val timestamp = System.currentTimeMillis()
}

case class ChainLink(index: Int, proof: Long, values: List[Transaction], previousHash: String = "",
                     tail: Chain = EmptyChain, timesTamp: Long = System.currentTimeMillis()) extends Chain {
  val hash = Crypto.sha256Hash(this.toJson.toString)
}
