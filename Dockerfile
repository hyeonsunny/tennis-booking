# Java가 포함된 기본 이미지 사용 (Eclipse Temurin 또는 OpenJDK 등)
FROM eclipse-temurin:17-jdk-jammy

# 애플리케이션 환경 변수 설정
ENV SPRING_PROFILES_ACTIVE=docker

# 로그를 외부에 저장할 수 있도록 볼륨 추가
VOLUME /tmp

# 컨테이너 작업 디렉토리 설정
WORKDIR /app

# Spring Boot에서 생성된 JAR 파일 복사
COPY ./build/libs/tennis-booking-0.0.1-SNAPSHOT.jar app.jar

# 애플리케이션 포트(기본 8080) 노출
EXPOSE 8080

# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
