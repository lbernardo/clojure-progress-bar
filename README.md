# progress-bar

A Clojure library designed to ... well, that part is up to you.

## Install
FIX
```
```

## Usage

````clojure
(ns example.core
  (:require [progress-bar.core :as pb]))

(loop [bar (pb/progress-bar 100)]
   (if (pb/is-done? bar)
     (println "Finish")
     (do
       (pb/increment bar)
       (Thread/sleep 1000)
       (recur bar))))
````

## Documentation

#### bp/progress-bar [total]
Create a new progress bar
```clojure
; Example
(pb/progress-bar 999) ; Create progress bar with 999 itens
```

#### bp/increment [bar ^increment]
Increment in progress and print progress bar
```clojure
; Example
(let [bar (pb/progress-bar 100)]
  (pb/increment bar) ; Increment in progress +1
  ; OR
  (pb/increment bar 10) ; Increment in progress +10
  (pb/increment bar 90))  ; Increment in progress +90
; Print in console
; 1/100 [>                                                    ]  [1.0%]
; 10/100 [=====>                                              ]  [10.0%]
; 100/100 [==================================================>]  [100.0%]
```


#### bp/is-done? [bar]
Return true or false when progress bar finish
```clojure
(let [bar (pb/progress-bar 100)]
  (pb/increment bar) ; Increment in progress +1
  (println (pb/is-done? bar)) ; Print false
  (pb/increment bar 90)
  (println (pb/is-done? bar))) ; Print true
```


#### bp/done [bar]
Finish progress-bar
````clojure
(let [bar (pb/progress-bar 100)]
  (pb/increment bar) ; Increment in progress +1
  (println (pb/is-done? bar)) ; Print false
  (pb/done bar)
  (println (pb/is-done? bar))) ; Print true
````

## License

Copyright (c) 2021 Lucas Bernardo

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
