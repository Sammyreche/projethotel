// export interface Reservation {
//     id:              string;
//     clientPrincipal: ClientPrincipal;
//     passagers:       Passager[];
//     dateDebut:       string;
//     dateFin:         string;
// }

// export interface ClientPrincipal {
//     id:     number;
//     nom:    string;
//     prenom: string;
// }

// export interface Passager {
//     id:     number;
//     nom:    string;
//     prenom: string;
// }

export interface ListeReservation {
    id:             number;
    dateDebut_resa: string;
    dateFin_resa:   string;
    nom:            string;
    prenom:         string;
    email:          string;
    telephone:      string;
    naissance:      string;
    nombrePassager: number;
}

export interface PageReservation {
    reservations : ListeReservation[];
    page : number;
    size :number;
    totalPages : number
}