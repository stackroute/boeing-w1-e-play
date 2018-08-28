import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { RsvpCreate } from "./RsvpCreate";
import { RsvpInvitation } from "./RsvpInvitation";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root"
})
export class RsvpCreateService {
  private _url: string = "http://13.232.40.6:8092/rsvp/api/v1/event/rsvpEvent";
  private _url1: string = "http://13.232.40.6:8092/rsvp/api/v1/event/rsvpEvents";
  private _url2: string = "http://13.232.40.6:8092/rsvp/api/v1/event/rsvpEvent/";
  private _url4: string = "http://13.232.40.6:8092/rsvp/api/v1/event/invitation";
  private _url3: string = "http://13.232.40.6:8092/rsvp/upstream/api/v1/upstream/rsvpEvent";

   

  rsvpCreate: RsvpCreate;
  // rsvpInvitationModel: RsvpInvitation;
  constructor(private http: HttpClient) {}

  saveRsvpEvent(rsvpCreate: RsvpCreate): Observable<RsvpCreate> {
    
    return this.http.post<RsvpCreate>("http://13.232.40.6:8092/upstream/api/v1/upstream/rsvpEvent", rsvpCreate);
  }

  getAllRsvpEvents(): Observable<RsvpCreate[]> {
    return this.http.get<RsvpCreate[]>(this._url1);
  }

  getRsvpEventById(id): Observable<RsvpCreate> {
    return this.http.get<RsvpCreate>(this._url2+id);
  }

  deleteRsvp(id) {
    return this.http.delete(this._url2 + id);
  }

  updateRsvp(rsvpInvitationModel: RsvpInvitation, id): Observable<RsvpCreate> {
    console.log(rsvpInvitationModel);
    console.log(id);
    return this.http.put<RsvpCreate>(
      this._url4 + "/" + id,
      rsvpInvitationModel
    );
  }

  
}
