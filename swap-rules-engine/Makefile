.PHONY: verify test it spotless package docker bench

verify:
	mvn -B verify -DskipITs=true -pl '!swap-rules-jmh,!swap-rules-loadtest'

test:
	mvn -B test

it:
	mvn -B verify -Pit

spotless:
	mvn spotless:apply

package:
	mvn -B package -DskipTests

docker:
	docker build -f swap-rules-admin/Dockerfile -t swap-rules-admin:local .

bench:
	mvn -pl swap-rules-jmh package -DskipTests
	java -jar swap-rules-jmh/target/benchmarks.jar -wi 2 -i 3 -f 1
