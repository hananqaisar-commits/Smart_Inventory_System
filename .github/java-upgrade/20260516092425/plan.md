# Java Upgrade Plan

Session: 20260516092425
Project: Smart_Inventory_System
Branch: main
Commit: N/A
Date: 2026-05-16

**Guidelines**
- Upgrade Java runtime to the latest LTS available on the host (Java 21 detected).

**Detected Tools**
- JDKs found: Java 21.0.10 (/usr/lib/jvm/java-21-openjdk-amd64/bin)
- Maven: /usr/share/maven/bin (no project wrapper detected at repository root)

**Options**
- Run tests before and after upgrade: true

**Key Challenges**
- Ensure `maven-compiler-plugin` and other build plugins support Java 21.
- Handle module-info and any deprecated APIs when moving to Java 21.
- Preserve existing behavior and pass all tests.

**Upgrade Steps**
1. Setup Environment — confirm JDK 21 available and set JAVA_HOME for the build.
2. Setup Baseline — `mvn -DskipTests=false clean test-compile` on current configuration; record results.
3. Apply Java Upgrade — update `pom.xml` to target Java 21 (maven-compiler-plugin `release` or `source`/`target`) and bump plugin versions if necessary.
4. Adjust Code — fix any compilation issues (module-info, APIs) introduced by Java 21.
5. Build & Test — run `mvn clean test`; iterate to fix failing tests until all pass.
6. Finalize — update `summary.md`, commit changes on branch `appmod/java-upgrade-20260516092425`.

**Deliverables**
- Updated `pom.xml` with Java 21 settings
- Any code fixes required for compilation/tests
- `.github/java-upgrade/20260516092425/progress.md` (progress tracking)
