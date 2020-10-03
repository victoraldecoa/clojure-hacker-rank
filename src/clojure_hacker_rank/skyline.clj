(ns clojure-hacker-rank.skyline)

(defn up
  [building heights output]
  [(into []  (sort-by last (conj heights building)))
   (if (< (last (last heights)) (last building))
     (conj output [(first building) (last building)])
     output)])

(defn down
  [building heights output]
  [(into [] (sort-by last (remove #(= % building) heights)))
   (if (< (last building) (last (last heights)))
     output
     (conj output [(building 1) (last (second (reverse heights)))]))])

(defn transform-to-events
  [buildings]
  (into []  (sort-by first (concat
                           (map (fn [b] [(b 0) b up  ]) buildings)
                           (map (fn [b] [(b 1) b down]) buildings)))))

(defn generate-skyline
  [buildings]
  (loop [heights []
         output []
         index 0
         events (transform-to-events buildings)]
    (if (>= index (count events)) output
        (recur [] [] (inc index) events))))
