import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Album} from "../models/album-library-model";

@Injectable({
  providedIn: 'root'
})
export class LibraryService {

  private baseURL = "http://localhost:8080/api/v1/albums";

  constructor(private httpClient: HttpClient) {
  }

  getAlbumLibrarysList(): Observable<Album[]> {
    return this.httpClient.get<Album[]>(`${this.baseURL}`);
  }

  createAlbumLibrary(album: Album): Observable<Object> {
    return this.httpClient.post(`${this.baseURL}`, album);
  }

  getAlbumLibraryById(id: string): Observable<Album> {
    return this.httpClient.get<Album>(`${this.baseURL}/${id}`);
  }

  updateAlbumLibrary(id: number, album: Album): Observable<Object> {
    return this.httpClient.put(`${this.baseURL}/${id}`, album);
  }

  deleteAlbumLibrary(id: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
}
