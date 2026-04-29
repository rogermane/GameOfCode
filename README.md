# Contexto
Proyecto de clase en el que teníamos que demostrar lo aprendido sobre OOP (Programación Orientada a Objetos), ENUMS e Interfaces.

# Funcionalidades Principales
Elección de modo de juego, Atacar, Usar Carta, Pasar Turno y Abrir Tienda.

# Stack Tecnológico
![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)

# Capturas


# Explicación de Ejecución
- JDK 25
- IDE con compilador de java

# Estructura

```txt
GameOfCode/
├── .idea/
│   ├── .gitignore
│   ├── misc.xml
│   ├── modules.xml
│   └── vcs.xml
├── src/
│   ├── Core/
│   │   ├── Carta.java
│   │   ├── CartaDagaEnvenenada.java
│   │   ├── CartaPocionMayor.java
│   │   ├── CartaRevivir.java
│   │   ├── CartaSubirNivel.java
│   │   ├── CartaXP.java
│   │   ├── Entidad.java
│   │   ├── GameOfCode.java
│   │   ├── Guerrero.java
│   │   ├── Mago.java
│   │   ├── Monstruo.java
│   │   ├── Rareza.java
│   │   ├── SubirNivel.java
│   │   └── Tienda.java
│   └── Main.java
├── .gitignore
├── README.md
└── GameOfCode.iml
```

# Decisiones Técnicas
- Se usa la librería `java.util.Scanner` para recibir los inputs.
- Se usa la librería `java.util.ArrayList` para usar las ArrayList, para almacenar información.
- Se definen ciertos codigos de color para texto que se usan en los distintos pasos del juego.
