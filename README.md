# uno-card-game

[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=tk-codes_uno&metric=coverage)](https://sonarcloud.io/dashboard?id=tk-codes_uno)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=tk-codes_uno&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=tk-codes_uno)

> v2.0: Rebuilt the core game logic in domain-driven-design.

![uno-ui](./doc/new-uno-v2.gif)
*Note: GUI is built merely to try out the core domain logic. It is not suitable for serious game. :)*

## Instructions

**Run Application**

Run the `main` method in the UnoApp class or use the following command in the terminal:

```
./gradlew run
```

**Run Unit Tests**

```
./gradlew test
```

## Event Storming

![event-storming](./doc/event-storming.jpg).

## Core Domain

The core game logic is built according
to [official uno rules](https://en.wikipedia.org/wiki/Uno_(card_game)#Official_rules).

### Uno Card

Cards are value objects, i.e. immutable. The following card types are available in Uno:

* Number Card
* Skip Action Card
* Reverse Action Card
* Draw Two Action Card
* Wild Color Card
* Wild Draw Four Card

Initially wild cards don't have a color. When drawn, a new value object is created with the chosen color.

![card-uml](./doc/cards.png)

### Player

`Player` is an entity which contains a list of hand cards to play.

`PlayerRoundIterator` manages the players and switches turn as if the players are in a round table.

![player-uml](./doc/player.png)

### Game

`Game` is the aggregate which maintains the state of **players**, **draw pile** and **discard pile** as the cards are
played.

![game-uml](./doc/game.png)

### Domain Events

`Game` aggregate produces domain events using `DomainEventPublisher`.

Subscribers can register for these events and handle them accordingly.

![events-uml](./doc/events.png)

搭建web服务器，使用Spring Boot框架

运行系统： ubuntu 22.04 安装gradle：

```shell
$ sudo apt install gradle
```

运行系统： macos 安装gradle：

```shell
$ brew install gradle
```

生成包装文件：
进入build.gradle所在目录，执行命令：

```
$ gradle wrapper
```

编译、打包：

```
$ ./gradlew clean build
```

运行:

```
$ ./gradlew bootRun
```

运行 jar 包

```bash
$ run-jar.sh
```

## java版本

```shell
$ java -version                                                                                                                                                           ⬡ 14.16.0 [±develop ●●]
java version "17.0.10" 2024-01-16 LTS
Java(TM) SE Runtime Environment Oracle GraalVM 17.0.10+11.1 (build 17.0.10+11-LTS-jvmci-23.0-b27)
Java HotSpot(TM) 64-Bit Server VM Oracle GraalVM 17.0.10+11.1 (build 17.0.10+11-LTS-jvmci-23.0-b27, mixed mode, sharing)
```
