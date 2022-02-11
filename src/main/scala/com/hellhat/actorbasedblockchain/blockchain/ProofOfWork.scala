package com.hellhat.actorbasedblockchain.blockchain

import scala.annotation.tailrec
import spray.json._
import com.hellhat.actorbasedblockchain.crypto.{Crypto}
import com.hellhat.actorbasedblockchain.blockchain.utils.JsonSupport._

object ProofOfWork {
  def ProofOfWork(lastHash: String): Long =
    @tailrec
    def proofOfWorkAcc(lastHash: String, proof: Long): Long =
      if isValidProof(lastHash, proof) then
        proof
      else
        proofOfWorkAcc(lastHash, proof + 1)
    
    proofOfWorkAcc(lastHash, 0)

  def isValidProof(lastHash: String, proof: Long): Boolean =
    val guess = (lastHash ++ proof.toString).toJson.toString
    val guessHash = Crypto.sha256Hash(guess)

    (guess take 4) == "0000"
}
