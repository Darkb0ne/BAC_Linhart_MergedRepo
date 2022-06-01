import { Sex } from "./IServerAuthor.model";

export interface IClientAuthor {
    id: number;
    sex: Sex;
    firstName: string;
    lastName: string;
    email: string;
}