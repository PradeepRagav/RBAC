# RBAC

- Used a N-array tree to represent the resources and resource groups.
  - Each node has 
      - id - Uniquely identifies a resource
      - userMap - An access map which conveys the user's role on that resource
      - childNodes - Resources under the node
      
- Support to only 3 types of roles and 3 types of action types
  - ADMIN (READ,WRITE,DELETE)
  - USER (READ,WRITE)
  - GUEST (READ)
- User can have access to multiple resources
  - Among the roles, the role with least depth will be considered.
- Running the program
  - `mvn clean package`
  - `java -jar <path>/target/locus-1.0-SNAPSHOT.jar`
