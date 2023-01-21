(ns clojure-hacker-rank.dynamic-array)

(defn dynamicArray [n queries]
  (loop
    [i 0
     queries queries
     arr (vec (repeat n []))
     last-answer 0]
    (if (< i n)
      (recur
        (inc i)
        (rest queries)
        arr
        last-answer)
      arr)))

(dynamicArray 2 ["1 0 5"
                 "1 1 7"
                 "1 0 3"
                 "2 1 0"
                 "2 1 1"])