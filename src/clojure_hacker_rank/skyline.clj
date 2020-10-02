(ns clojure-hacker-rank.skyline)

(defn up
  [building heights output]
  [(sort-by last (conj heights building))
   (if (< (last (last heights)) (last building))
     (conj output [(first building) (last building)])
     output)])

(defn down
  [building heights output]
  [[] []])

(defn transform-to-events
  [buildings]
  (sort-by first (concat
                  (map (fn [b] [(b 0) b up  ]) buildings)
                  (map (fn [b] [(b 1) b down]) buildings))))

(defn generate-skyline
  [buildings]
  (loop [heights []
         output []
         index 0
         events (transform-to-events buildings)]
    (if (>= index (count events)) output
        (recur [] [] (inc index) events))))
