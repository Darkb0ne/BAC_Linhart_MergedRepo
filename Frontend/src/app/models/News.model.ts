import { IServerAttraction } from "./IServerAttraction.model";
import { IServerNews } from "./IServerNews.model";

export class News implements IServerNews{
    id: number;
    title: string;
    text: string;
    publicationDate: Date;
    viewCount: number;
    topnews: boolean;
    attraction: IServerAttraction;

    constructor(id: number, title: string, text: string, publicationDate: Date, viewCount: number, topnews: boolean, attraction: IServerAttraction){
        this.id = id;
        this.title = title;
        this.text = text;
        this.publicationDate = publicationDate;
        this.viewCount = viewCount;
        this.topnews = topnews;
        this.attraction = attraction;
    }
}