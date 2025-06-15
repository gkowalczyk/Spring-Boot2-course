FROM quay.io/keycloak/keycloak:24.0.3

ENV KYECLOAK_ADMIN=admin
ENV KEYCLOAK_ADMIN_PASSWORD=admin

RUN /opt/keycloak/bin/kc.sh build

CMD ["start"]