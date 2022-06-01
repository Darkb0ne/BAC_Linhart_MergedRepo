export enum Sex {
    Female = 'FEMALE',
    Intersex = 'INTERSEX',
    Male = 'MALE'
}

export interface IServerAuthor {
    id: number;
    sex: Sex;
    firstName: string;
    lastName: string;
    email: string;
}