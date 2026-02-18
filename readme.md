
# SAP BTP + Datadog: E2E Observability Demo 🚀

Este proyecto demuestra la integración de **Full-Stack Observability** conectando un frontend en SAPUI5 con un backend Java Spring Boot desplegado en **SAP Business Technology Platform (BTP)**, todo monitoreado en tiempo real con **Datadog**.

## 🏗️ Arquitectura
- **Frontend:** SAPUI5 (HTML5/JS) con Datadog RUM.
- **Backend:** Java 17 + Spring Boot con Datadog APM.
- **Cloud:** SAP BTP (Cloud Foundry Runtime).
- **Tracing:** W3C TraceContext para correlación frontend-to-backend.



## 🚀 Configuración de Backend + Frontend
El backend utiliza el **Datadog Cloud Foundry Buildpack**. El archivo `manifest.yml` incluye las variables necesarias para el despliegue automático del agente.

```yaml
applications:
- name: sap-java-backend
  path: target/demo-0.0.1-SNAPSHOT.jar
  buildpacks:
    - https://github.com/DataDog/datadog-cloudfoundry-buildpack/releases/download/4.46.0/datadog-cloudfoundry-buildpack-4.46.0.zip
    - java_buildpack
  env:
    DD_SERVICE: "sap-java-backend"
    DD_ENV: "dev"
    DD_RUN_AGENT: "true"
```

🌐 Configuración del Frontend (RUM)
El frontend inicializa el SDK de Datadog y habilita el rastreo distribuido hacia el dominio de SAP BTP.

JavaScript

```code
DD_RUM.init({
    clientToken: 'TU_CLIENT_TOKEN',
    applicationId: 'TU_APP_ID',
    site: 'datadoghq.com',
    service: 'ui5-frontend',
    allowedTracingUrls: [
        { match: "[https://tu-backend-btp.hana.ondemand.com](https://tu-backend-btp.hana.ondemand.com)", propagatorTypes: ["tracecontext"] }
    ]
});
```

📊 Capacidades de la Demo
Distributed Tracing: Ver el salto exacto desde el clic del usuario hasta el código Java.
Session Replay: Reproducción visual de la interacción del usuario.
Error Tracking: Consolidación de errores de JS y excepciones de Java en una sola vista.
JVM Metrics: Monitoreo de Heap Memory y Garbage Collection en el contenedor de BTP.
Desarrollado para demostraciones técnicas de observabilidad en ecosistemas SAP.



---


Conecta con tu repo (Copia el link de tu repo en GitHub):
Bash
git branch -M main
git remote add origin https://github.com/TU_USUARIO/NOMBRE_DEL_REPO.git
git push -u origin main

