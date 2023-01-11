export interface Reservation {
    id:              string;
    clientPrincipal: ClientPrincipal;
    passagers:       Passager[];
    dateDebut:       string;
    dateFin:         string;
}

export interface ClientPrincipal {
    id:     number;
    nom:    string;
    prenom: string;
}

export interface Passager {
    id:     number;
    nom:    string;
    prenom: string;
}
