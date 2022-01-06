import {Component, OnInit} from '@angular/core';
import {SpotifyApiService} from "../../services/spotify-api.service";
import {AlbumsItem} from "../../models/search-model";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  constructor(private spotifyApiService: SpotifyApiService) {
  }

  searchedAlbums: AlbumsItem[] = [];

  ngOnInit(): void {
    this.spotifyApiService.getAlbums('bonobo').subscribe(res => {
        this.searchedAlbums = res.items;
        console.log(res.items)
      }
    )
  }

}
