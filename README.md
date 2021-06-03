## Micronaut 2.5.5-SNAPSHOT Documentation

- [User Guide](https://docs.micronaut.io/snapshot/guide/index.html)
- [API Reference](https://docs.micronaut.io/snapshot/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/snapshot/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)

## Ambassador documentation
- [Mapping resource](https://www.getambassador.io/docs/edge-stack/latest/topics/using/intro-mappings/)
- [SSO with Azure AD](https://www.getambassador.io/docs/edge-stack/latest/howtos/sso/azure/)

## Helm
`helm install --namespace $NAMESPACE micronaut-ambjwt ambassador-jwt --set dnsZone=$DNSZONE --set azure.tenantID=$TENANTID --set azure.clientID=$CLIENTID --set azure.secret=$SECRET --set image.repository=$DOCKERREPO/ambassador-jwt`