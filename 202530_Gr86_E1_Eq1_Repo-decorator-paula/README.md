# 202530_Gr86_E1_Eq1_Repo
## Integrantes
- Paula valentina leon pardo 
- Adiel Valentin Hernadez 
- Maria Fernanda Velez Benitez
- Jhoan Stivewn Bohorques Herran

## Planteamiento del problema
Diseñar e implementar un sistema de generación de informes modulares que emplee de forma combinada los patrones Bridge, Decorator, Flyweight y Proxy, atendiendo a los siguientes requisitos:
### Bridge – Separación de formato de contenido
- Define una abstracción Report que represente un informe genérico, hay también reportes detallados y reportes ejecutivos.
- Separa la implementación de exportación (Exporter) de la abstracción, de modo que puedas añadir nuevos formatos de salida (por ejemplo, PDFExporter, HTMLExporter, MarkdownExporter) sin modificar las clases de los informes.
### Decorator – Adición dinámica de secciones
- Permite enriquecer un Report con elementos adicionales en tiempo de ejecución: portada, tabla de contenidos, encabezados y pies de página, marcas de agua, etc.
### Flyweight – Reutilización de estilos tipográficos
- Identifica el estado intrínseco compartible de los estilos de texto (tipo de letra, tamaño, color).
- Crea un StyleFactory que gestione un pool de objetos TextStyle y devuelva instancias compartidas para evitar duplicar en memoria estilos iguales.
### Proxy – Control de acceso
- Verificación de permisos: solo usuarios con rol “Administrador” pueden incorporar decoradores.
## Calificación:
- Diagrama UML de la solución. (2 PUNTOS)
- Código Java aplicación funcional (GitHub). (2 PUNTOS)
- Exposición de la aplicación. (1 PUNTO)
