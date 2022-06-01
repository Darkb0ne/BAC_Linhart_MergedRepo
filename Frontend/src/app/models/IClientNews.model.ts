import { IServerAttraction } from "./IServerAttraction.model";

export interface IClientNews {
    title: string;
    text: string;
    publicationDate: Date;
    viewCount: number;
    topnews: boolean;
    attraction: IServerAttraction
}