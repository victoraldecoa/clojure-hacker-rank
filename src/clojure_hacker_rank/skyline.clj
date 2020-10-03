(ns clojure-hacker-rank.skyline)

(defn up
  [building heights output]
  [(conj heights building)
   (if (< (last (first heights)) (last building))
     (conj output [(first building) (last building)])
     output)])

(defn down
  [building heights output]
  (let [new-heights (disj heights building)]
    [new-heights
     (if (< (last building) (last (first heights)))
       output
       (conj output [(building 1) (last (first new-heights))]))]))

(defn transform-to-events
  [buildings]
  (into []  (sort-by first (concat
                            (map (fn [b] [(b 0) b up]) buildings)
                            (map (fn [b] [(b 1) b down]) buildings)))))

(defn create-set
  [& keys]
  (apply sorted-set-by (fn [x y] (compare (last y) (last x))) [nil nil 0] keys))

(defn generate-skyline
  [buildings]
  (loop [heights (create-set)
         output []
         index 0
         events (transform-to-events buildings)]
    (if (>= index (count events)) output
        (let [event (events index)]
          (let [next ((last event) (second event) heights output)]
            (recur (first next) (second next) (inc index) events))))))
