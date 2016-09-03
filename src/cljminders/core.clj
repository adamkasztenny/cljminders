(ns cljminders.core
  (:require [cljminders.db.dbConnection :as db])
  (:gen-class))

(defn -main
  "Print intro screen, starting point of execution"
  [& args]
  (println "Welcome to cljminders!")
)
