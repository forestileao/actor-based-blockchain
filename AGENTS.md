**Purpose**
- Provide a concise, repeatable guide for how an AI coding agent should work in this Scala/SBT project.
- Keep guidance aligned with other repos while recording project‑specific run/test steps.

**Scope**
- Applies to the entire repository. The agent may edit source, tests, and build files to improve reliability.
- Do not introduce external services, secrets, or license changes without maintainer approval.

**Repository Layout Highlights**
- SBT build: build.sbt, project/*.sbt, project/build.properties (sbt 1.6.2).
- Sources: src/main/scala/com/hellhat/actorbasedblockchain/**.
- No tests are present by default; add under src/test/scala.

**Run**
- Requirements: JDK 11+ and sbt.
- Compile the project: sbt compile
- There is no main class wired for sbt run; use sbt console to experiment or add an entry point if needed.

**Test**
- Run the test suite (if tests exist): sbt test
- Recommended testing stack: ScalaTest or MUnit. Place suites under src/test/scala with package mirrors.

**Lint/Format**
- No formatter or linter is configured in this repo. Follow standard Scala style (2‑space indent; meaningful names; prefer vals; explicit types on public APIs).
- If scalafmt is later enabled, run: sbt scalafmtAll and enforce with scalafmtCheckAll in CI.

**Build/CI**
- No CI is defined. If you add CI, cache sbt and Coursier; run compile and test tasks.

**Coding Conventions and Naming**
- Package: com.hellhat.actorbasedblockchain.
- Prefer immutable data (case classes, vals) and pure functions.
- Keep functions small; avoid side effects in domain code.
- Use Scala 3 idioms (given/using, extension methods) when appropriate.

**Decision Records (optional)**
- For notable design choices, add docs/decisions/YYYY-MM-DD-slug.md with context, options, decision, and consequences.

**Secrets Policy**
- Never commit tokens, secrets, or credentials. Configuration should come from environment variables or local dev files ignored by VCS.

**PR Checklist**
- Build: sbt compile succeeds without warnings you can reasonably fix.
- Tests: sbt test passes locally (or explain absence of tests).
- No secrets added; no license or authorship changes.
- Updated docs if commands, structure, or requirements changed.

**How to Update This File**
- Keep it under 200 lines; avoid placeholders. Update commands if the build changes.
