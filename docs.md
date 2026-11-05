# actor-based-blockchain

Scala 3 code exploring blockchain-building blocks (transactions, chain links, and proof of work) with JSON support. The project uses Akka and Spray JSON and is built with `sbt`.

## Quick start

Prerequisites:
- JDK 11+ (compatible with Scala 3.1.1)
- sbt (Scala build tool)

Compile the project:
```sh
sbt compile
```
Optionally inspect/test code from the REPL:
```sh
sbt console
```

Note: No application entrypoint is defined at the moment (no `@main` or `extends App`), so `sbt run` is not expected to launch an app.

## Testing

Run the test suite (if/when tests are added):
```sh
sbt test
```
By convention, tests live under `src/test/scala/`.

## Project layout

- `build.sbt` — sbt build definition and dependencies.
- `src/main/scala/` — main source tree.
  - `com/hellhat/actorbasedblockchain/blockchain/`
    - `Transaction.scala` — basic transaction model.
    - `Chain.scala` — immutable chain and chain links.
    - `ProofOfWork.scala` — simple proof-of-work routine.
    - `utils/JsonSupport.scala` — Spray JSON formats for models.
  - `com/hellhat/actorbasedblockchain/crypto/Crypto.scala` — SHA‑256 helper.

## License & contributing

If this repository later adds `LICENSE` or contributing guidelines, consult those files for terms and contribution process.
