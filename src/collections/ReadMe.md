### Урок 4. Коллекции <br>
#### Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников. <br>
#### Каждый сотрудник должен иметь следующие атрибуты: <br> **Табельный номер, Номер телефона, Имя, Стаж** <br> 
#### Добавить метод, который ищет сотрудника по стажу (может быть список) <br>
#### Добавить метод, который выводит номер телефона сотрудника по имени (может быть список). <br> 
#### Добавить метод, который ищет сотрудника по табельному номеру. <br>
#### Добавить метод добавление нового сотрудника в справочник сотрудников. <br>
```
HashMap<String,Object> map=new HashMap<String,Object>();
Set<Map.Entry<String,Object>> entrySet=map.entrySet();

Object desiredObject=new Object();//что хотим найти
for (Map.Entry<String,Object> pair : entrySet) {
if (desiredObject.equals(pair.getValue())) {
return pair.getKey();// нашли наше значение и возвращаем ключ
}
```
```
}
Map<String, Object> maps = new HashMap<>();
Object value = new Object();

Optional<String> result = maps.entrySet()
.stream()
.filter(entry -> value.equals(entry.getValue()))
.map(Map.Entry::getKey)
.findFirst();

if (result.isPresent())
System.out.println(result.get());
```
