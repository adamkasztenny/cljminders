(ns cljminders.db.operations
  (:require [cljminders.db.connection :as db])
)

(use 'korma.db)
(use 'korma.core)

(defn selectReminders [] (select db/reminders))
