(defproject clojure-hacker-rank "0.0.1"
  :description "Set of submissions to Hacker Rank problems solved in Clojure."
  :url "https://github.com/victoraldecoa/clojure-hacker-rank"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :plugins [[lein-cloverage "1.1.2"]]
  :cloverage {:ns-exclude-regex [#"clojure-hacker-rank.core"]
              :codecov? true}
  :dependencies [[org.clojure/clojure "1.10.0"]]
  :main ^:skip-aot clojure-hacker-rank.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
