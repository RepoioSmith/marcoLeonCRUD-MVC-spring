DROP TABLE IF EXISTS libros;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE libros (
  id int NOT NULL AUTO_INCREMENT,
  nombre varchar(100) NOT NULL,
  autor varchar(100) NOT NULL,
  editorial varchar(100) NOT NULL,
  isbn varchar(100) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY isbn (isbn)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;