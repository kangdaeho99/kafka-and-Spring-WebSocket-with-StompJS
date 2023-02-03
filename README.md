<!-- # Multi-Chatting-Using-kafka-and-Spring-WebSocket-with-SockJS-StompJS -->

<!--
## 👩🏻‍💻 토이 Projects

---
-->

### 🏫 Multi-Chatting-Using-kafka-and-Spring-WebSocket-with-SockJS-StompJS(Kafka와 Spring을 활용하여 양방향 통신 구현)

**프로젝트 설명** 

- Spring WebSocket과 Kafka, SockJS, StompJS를 활용하여 양방향 통신 프로그램을 만들어보았습니다.

<!-- ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f981aa71-2263-4cc0-9229-1567f0bce802/Untitled.png) -->
<img src="https://user-images.githubusercontent.com/48047377/216617569-a220dce7-2994-4c8e-ba01-cfab6d61bbce.png"/>

**프로젝트 기획의도**

- 이 프로젝트에서는 카프카 브로커 1대에 주키퍼가 관리하도록 하여 데이터를 분산시켜 처리하여 서버과부하를 막고, 서버안정성을 높이기 위한 방안 중 하나인 Kafka에 대해 알아보고자 만들어보았습니다.
- AWS 프리티어 할당문제로 1대만 올렸습니다.

**개발목표**

- AWS EC2 에 AML 환경을 통해 Kafka와 Zookeeper를 배포시킵니다.
- Spring Kafka를 Java Configuration으로 연동합니다.
- Spring Kafka와 WebSocket을 연동합니다.

**개발과정**

- Kafka란 무엇인가?에 대하여 알아보고자 Kafka 레퍼런스를 참조하여 블로그에 글을 남겨보았습니다. ([[Spring] Kafka [1] (카프카 Getting Started)](https://passionfruit200.tistory.com/178))
- Kafka를 Spring FrameWork with Java Configuration 환경에서 실행해보고자 Spring-Kafka QuickTour 레퍼런스를 참조하여 구현해보았습니다. ( [[Spring] Kafka [2](카프카 Quick Tour with Java Configuration)](https://passionfruit200.tistory.com/180) )
- WebSocket with STOMP, SOCKJS 같은경우 이전에 구현경험이 있어 구현했습니다.

## 📜 기술 스택

---

### Front & Backend

- java 1.8
- Spring Framework 5.0.7
- HTML/CSS, JAVASCRIPT
- Kafka 1.0

### Maven Added Library

- **For Kafka :** Spring-Kafka
- **For WebSocket** : Spring-WebSocket, Spring-Messaging, javax.websocket-api,
- **For Data Format** : jackson-databind, jackson-dataformat-xml

### Infrastructure

- Spring Framework with Github Actions
- AWS EC2, Kafka, ZooKeeper
- Apache Tomcat 9.0.30

## 🐕‍🦺 실행이미지

---

<!-- ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/b671a44f-ecd1-4dbe-a25f-43fca954bc3e/Untitled.png) -->

<img src="https://user-images.githubusercontent.com/48047377/216617535-cf72ddd6-a68b-42cd-8716-0d58ea2f4411.png"/>
[step 0].WebSocket 양방향 통신 확인을 위한 브라우저 크롬 1개, Internet Explorer 1개를 킵니다.

[step 1].메세지를 보내고자 하는자가 “Message Check! I am sending it!”라고 발송합니다.

[step 2].두개에 같은 메세지가 뜨는지 확인합니다.

<!-- ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/9d93f602-3c76-4f2e-a95f-812e5fe1d6cc/Untitled.png) -->
<img src="https://user-images.githubusercontent.com/48047377/216617621-f25c93f4-ec87-450d-8882-3d2f2014316f.png"/>
[step 3]. Kafka에 값이 올바르게 들어갔는지 확인합니다.
