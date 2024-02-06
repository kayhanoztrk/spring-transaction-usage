# Transaction Propagation

Transaction propagation attribute allows us to
control transaction. We can start new transaction or use existing
transaction.That sample project will be using propagation values.
You can pull and check propagation attributes with 
that sample project.

| PROPAGATION_REQUIRED                       | DESCRIPTION                                                                                                  |
|--------------------------------------------|--------------------------------------------------------------------------------------------------------------|
| @Transactional(propagation = Propagation.REQUIRED) | Default scope. If there is no transaction, create new transaction<br/>but if exists, reuse that transaction. |
| @Transactional(propagation = Propagation.REQUIRES_NEW) | Never participating in an existing transaction. Create a new transaction.                                    |
| @Transactional(propagation = Propagation.SUPPORTS) | If there is a transaction, use it. But if there is no transaction for outer method or class, run without transaction.                                                                                          
| @Transactional(propagation = Propagation.MANDATORY) | If a transaction doesn’t exist, an exception is thrown.                                                                                               
| @Transactional(propagation = Propagation..NOT_SUPPORTED)     | If there is a transaction, suspend it and run without transaction.                                                                                                 
