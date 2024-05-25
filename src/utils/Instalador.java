package utils;

import Services.IsistemaDeckList;
import Services.SistemaDeckList;

public class Instalador {
        private IsistemaDeckList sistemaDecklist;

        public Instalador() {
            this.sistemaDecklist = new SistemaDeckList();
        }

        public IsistemaDeckList instalarSistema() {
            return this.sistemaDecklist;
        }
    }

