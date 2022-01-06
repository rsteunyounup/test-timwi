import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {APIAlbums} from "../models/album-model";
import {catchError, map} from "rxjs/operators";
import {Albums, APISearch} from "../models/search-model";

@Injectable({
  providedIn: 'root'
})
export class SpotifyApiService {

  constructor(private http: HttpClient) { }

  private getQuery(query: string): any {
    const url = `https://api.spotify.com/v1/${query}`;

    const headers = new HttpHeaders({
      Authorization: 'Bearer BQC8xCDOz1yzSm4NWHPuZqRdeKdIMAdMWSmAPl4QWxnXjeA64TchzGcqjFG_AF6mgs539sQ5P8Df5rd1PU7Pv2xAfEdwIiao6azTlyZHFmhTxgszwyRPEDTB-NsByFkOwX777kk'
    });

    return this.http.get(url, {headers});
  }

  public getAlbum(albumId: string): Observable<APIAlbums> {
    const albumUrl: string = `albums/${ albumId }`;

    return this.getQuery(albumUrl).pipe(
      map((res: APIAlbums) => {
        if (!res){
          throw new Error('Value expected!');
        } else {
          return res;
        }
      }),
      catchError((err) => {
        throw new Error(err.message);
      }));
  }

  public getAlbums(term: string): Observable<Albums> {
    const searchUrl: string = `search?q=album:${term}%20artist:${term}&type=album`;

    return this.getQuery(searchUrl).pipe(
      map((res: APISearch) => {
        if (!res) {
          throw new Error('Value expected!');
        } else {
          console.log('res:', res['albums']);
          return res['albums'];
        }
      }),
      catchError((err) => {
        throw new Error(err.message);
      }));
  }
}
