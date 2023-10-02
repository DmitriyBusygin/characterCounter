### REST-сервис, вычисляющий частоту встречи символов по заданной строке.

### Использовались:
- Spring Boot
- Lombok

### Описание API:

Контекст приложения: `/api`

Реализован POST-метод: `count`

Тело запроса: `json`

> Запрос: 
> 
> `POST http://localhost:8080/api/count`
>```JSON
>{
>  "stringForCounting": "aabbbc"
>}
> ```
> Ответ:
>```JSON
> [
>   {
>     "symbol": "b",
>     "count": 3
>   },
>   {
>     "symbol": "a",
>     "count": 2
>   },
>   {
>     "symbol": "c",
>     "count": 1
>   }
> ]
> ```

**Запуск приложения:**

1. Должен быть установлен и запущен Docker
2. Клонировать проект
3. Выполнить команду `docker build -t character-counter .`
4. Выполнить команду `docker run -p8080:8080 character-counter`