import { IServerAttraction } from "./IServerAttraction.model";

export interface IServerNews {
    id: number;
    title: string;
    text: string;
    publicationDate: Date;
    viewCount: number;
    topnews: boolean;
    attraction: IServerAttraction
}

export interface IDictionary {
    [key: string]: number;
}

export interface IStatisticsServerNews {
    title: string;
    viewCount: number;
}

export interface IPostNews {
    authorIds: number[],
    attractionName: string,
    newsTitle: string,
    newsText: string
}