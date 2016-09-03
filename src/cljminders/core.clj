(ns cljminders.core
  (:require [cljminders.db.operations :as operations])
  (:gen-class))

(defn -main
  "Print intro screen, starting point of execution"
  [& args]
  (println "\nWelcome to cljminders!")
  (def rems (operations/selectReminders))
  (println rems)
)
