# Hibernate PrePersist bug

With composite keys and `@IdClass` annotation the entity methods with `@PrePersist` and `@PostPersist`
annotations are called twice.