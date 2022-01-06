import {Component, OnInit} from '@angular/core';
import {SpotifyApiService} from "../../services/spotify-api.service";
import {AlbumsItem} from "../../models/search-model";
import {LibraryService} from "../../services/library.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  constructor(
    private spotifyApiService: SpotifyApiService,
    private libraryService: LibraryService
  ) {
  }

  findedAlbums: AlbumsItem[] = [];

  ngOnInit(): void {
    this.spotifyApiService.getAlbums('bonobo').subscribe(res => {
        this.findedAlbums = res.items;
        console.log(res.items)
      }
    )

    this.libraryService.getAlbumLibraryById('ref_1').subscribe(res => {
      console.log(res);
    });
  }

}
