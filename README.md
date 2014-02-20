PRFLR SDK.Android
=================

HOW TO USE
==========
1 - Скачиваем библиотеку и добавляем в проект.
2 - В AndroidManifest, в секцию application добавляем следующую строку <meta-data android:name="apiKey" android:value="ваш_Api_ключ"/>
3 - Делаем PRFLRWrapper.init(Context) вне основного потока(из-за ограничений Андроида работа с сетью не осуществляется в основном потоке).
4 - Устанавливаем таймеры:
  PRFLRWrapper.begin(timerName); начинает таймер с заданным именем.
  PRFLRWrapper.end(timerName, info); завершает таймер с заданным именем и передает данные на сервер(включая строку info).
Пример: 
  PRFLRWrapper.init(Контекст);
  PRFLRWrapper.begin("doAnything");
  try {
      Thread.sleep(1000);
  } catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
  }
  PRFLRWrapper.end("doAnything", "success");
