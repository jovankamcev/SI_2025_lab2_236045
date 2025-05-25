Jovan Kamchev 236045

![Untitled Diagram](Untitled%20Diagram.png)

Цикломатска комплексност

Комплексноста е пресметана врз основа на бројот на услови и циклуси во функцијата.

Вкупно се појавуваат 6 if услови:
if (allItems == null)

if (item.getName() == null || item.getName().length() == 0)

if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10)

if (item.getDiscount() > 0)

if (cardNumber != null && cardNumber.length() == 16)

if (allowed.indexOf(c) == -1)

Некои од условите користат логички оператори ||, што додава дополнителни патеки.

Формула: M = број на услови и циклуси + 1 = 10 + 1 = 11

Тест случаи според Every Statement критериум

Критериумот Every Statement налага секоја линија од кодот да биде извршена најмалку еднаш. За да го задоволиме овој критериум, дефинирани се следниве тест случаи кои опфаќаат различни сценарија:

Бр. Опис на тест случајот Влезни податоци Очекуван резултат

1 Влезната листа со предмети е null allItems = null, cardNumber = "1234567890123456" Фрлање на исклучок: allItems list can't be null!

2 Предмет со празно или null име Листа со еден Item каде name = null или "" Фрлање на исклучок: Invalid item!

3 Невалиден број на картичка (помалку од 16 знаци) Влезен cardNumber = "1234" Фрлање на исклучок: Invalid card number!

4 Предмет со цена поголема од 300, без попуст Item со price = 400, quantity = 2, discount = 0 Вкупен износ со одземање 30 од сумата

5 Предмет со валиден попуст Item со price = 100, quantity = 1, discount = 0.2 Вкупен износ се пресметува со применет попуст

6 Валиден предмет и валиден 16-цифрен број на картичка Еден или повеќе предмети, картичка со сите цифри Враќа точна сума без исклучоци

7 Картичка содржи недозволени знаци Картичка со 16 карактери, но со букви или симболи Фрлање на исклучок: Invalid character in card number!
Минимален број на тест случаи: 7

Тест случаи според Multiple Condition

if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10)

Тест случај Price > 300 Discount > 0 Quantity > 10 Вредност на условот (OR) Објаснување

FFF False False False False Ниту еден од условите не е исполнет, условот е false

FFT False False True True Tретиот услов е True, значи целата логика е True

FTF False True False True Вториот услов е True, условот е True

FTT False True True True Вториот и третиот услов True, логика True

TFF True False False True Првиот услов е True, условот е True

TFT True False True True Првиот и третиот услов True, условот True

TTF True True False True Првиот и вториот услов True, условот True

TTT True True True True Сите услови True, логиката е True

Мора да има најмалку 8 тест случаи

