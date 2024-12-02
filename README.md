# E-commerce-Application

[Макет магазина](https://github.com/EugeneKroshinsky/E-commerce-Application/blob/main/Online-Shop.pdf)

[Макет базы данных](https://github.com/EugeneKroshinsky/E-commerce-Application/blob/main/database_model.png)

Стек технолигий: Java EE, Tomcat, JSP, PostgreSQL

# План разработки интернет-магазина

План на числа после 6го будет дополнятся более детально.

## **28.11: Создание проекта**
- Настройка Tomcat и Java EE.
- Настройка подключения к базе данных с использованием Hibernate.
- Создание таблиц в базе данных для:
  - Пользователей (ID, имя, фамилия, email, пароль, номер телефона).
  - Товаров (ID, название, описание, цена, количество, категория, фото).
  - Заказов (ID, дата, пользователь, адрес, комментарий, статус).
  - Корзины (ID, пользователь, товары, общее количество и цена).
  - Истории заказов.
## **29.11 — 1.12: Главная страница**
- Создание главной страницы приложения
- Отображение всех товаров
- Страница товара
- Работа с корзиной(сохранение товаров в сессии)
  - Страница корзины
  - Добавление в корзину
## **2.12 - 5.12: Управдение заказами и продуктами**
- Оформление заказа 
  - Создание html-форм
  - Добавление в базу данных
- Разработка панели администратора(добавление товаров, изменение товаров, просмотр всех заказов, поддтверждение заказов)
  - Создание html страниц
  - Работа с бд
- Шифрование паролей в базе данных
- Реализация фильтра товаров
- Подгрузка картинок из базы данных
---

## **6.12 — 13.12: Авторизация**
- Реализация авторизации:
  - Логика входа и регистрации в бэкенде.
- **Страницы JSP:**
  - Авторизация (email и пароль).
  - Регистрация (имя, фамилия, телефон, email, пароль).
- **Страница профиля:**
  - Отображение информации о пользователе и истории заказов (ID, дата, сумма).

---

## **14.12 — 16.12: Тестирование**
- **Тестирование всех функций сайта:**
- **Исправление багов и недочётов.**
- **Развёртывание готового приложения на сервере Tomcat.**

