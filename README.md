PRFLR SDK.Android
=================

##HOW TO USE

1. Скачиваем библиотеку и добавляем в проект.
2. В AndroidManifest, в секцию application добавляем следующую строку <meta-data android:name="apiKey" android:value="ваш_Api_ключ"/>
3. Делаем PRFLRWrapper.init(Context)
4. Устанавливаем таймеры:

```java

// начинает таймер с заданным именем.
PRFLR.begin(timerName);
// завершает таймер с заданным именем и передает данные на сервер(включая строку info).
PRFLR.end(timerName, info);

```

Пример:

```java

PRFLR.init(context);
PRFLR.begin("doAnything");

try {
    Thread.sleep(1000);
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}

PRFLR.end("doAnything", "success");

```