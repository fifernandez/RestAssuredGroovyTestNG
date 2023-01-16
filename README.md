# RestAssuredGroovyTestNG

API Automation using Rest Assured, TestNG, Groovy and Gradle.

| Job        | Status                                                                                                                                                                                                                        | Report                                                                                                                                                                                  |
|------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Smoke      | [![Smoke Tests](https://github.com/fifernandez/RestAssuredGroovyTestNG/actions/workflows/smoke-tests.yml/badge.svg)](https://github.com/fifernandez/RestAssuredGroovyTestNG/actions/workflows/smoke-tests.yml)                | [<img src="https://avatars.githubusercontent.com/u/5879127?s=200&v=4" width="15" alt="Allure Report"/> Allure Report](https://fifernandez.github.io/RestAssuredGroovyTestNG/smoke)      |
| Regression | [![Regression Tests](https://github.com/fifernandez/RestAssuredGroovyTestNG/actions/workflows/regression-tests.yml/badge.svg)](https://github.com/fifernandez/RestAssuredGroovyTestNG/actions/workflows/regression-tests.yml) | [<img src="https://avatars.githubusercontent.com/u/5879127?s=200&v=4" width="15" alt="Allure Report"/> Allure Report](https://fifernandez.github.io/RestAssuredGroovyTestNG/regression) |
To run the tests:
-
Option 1:

- Execute:  ./gradlew test
- Low console output, just the names of the scenarios and the result.

Parameters:
- 

- Env:
    - You can choose which environment you are going to test.
    - Add to command line: -Denv=desired
    - Available: dev, qa, stage, prod
    - Default: prod
    - A tag for the environment will be automatically added, so only scenarios that have the selected environment tag
      will run.


- Mode:
    - You can choose if you want to use public urls or private.
    - Add to command line: -Dmode=desired
    - Available: private, public
    - Default: public


- Tags:
    - You can choose which scenarios you want to run.
        - Add to command: -tags="desired"
        - Remember each scenario starts with @
        - You can use "and", "or", "not" operators and also "(" or ")".
        - Example: -Dtags="@2 and not @3"
        - A tag for the environment will be automatically added, so only scenarios that have the selected environment
          tag will run.
        - You can disable tests adding the tag @disable.
