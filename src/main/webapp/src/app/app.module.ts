import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HomeComponent} from './pages/home/home.component';
import {LibraryComponent} from './pages/library/library.component';
import {AlbumCardComponent} from './shared/album-card/album-card.component';
import {SearchComponent} from './shared/search/search.component';
import {HeaderComponent} from "./shared/header/header.component";
import {HttpClientModule} from "@angular/common/http";
import {UriPipe} from './pipes/uri.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    LibraryComponent,
    AlbumCardComponent,
    SearchComponent,
    UriPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
