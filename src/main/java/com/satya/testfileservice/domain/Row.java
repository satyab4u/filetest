package com.satya.testfileservice.domain;

/**
 * Created by Satya on 11/25/19.
 */
public class Row {
    public Boolean[] getSeats() {
        return seats;
    }

    public void setSeats(Boolean[] seats) {
        this.seats = seats;
    }

    private Boolean[] seats;

    public int availableSeats() {
        int count = 0;
        for(Boolean seat: seats) {
            if(seat) {
                count++;
            }
        }
        return count;
    }

   /* public boolean checkSeats(int requiredSeats) {
        if(seatsAvailable() < requiredSeats || requiredSeats > this.seats.length) {
            return false;
        }
        boolean isAvailable = false;
        for(int i=0; i < seats.length; i=i+requiredSeats) {
            isAvailable = false;
            for(int k=i;k<i+requiredSeats;k++) {
                if(seats[k]) {
                   isAvailable = true;
                } else {
                    break;
                }
            }
            if(isAvailable) {
                return isAvailable;
            }
        }
        return isAvailable;
    }*/

    public int checkSeats(int requiredSeats) {
        int result = -1;
        if(availableSeats() < requiredSeats || requiredSeats > this.seats.length) {
            return result;
        }
        boolean isAvailable = false;
        for(int i=0; i < seats.length; i++) {
            isAvailable = false;
            for(int k=i;k<i+requiredSeats;k++) {
                if(seats[k]) {
                    isAvailable = true;
                } else {
                    break;
                }
            }
            if(isAvailable) {
                return i;
            }
        }
        return result;
    }


    public boolean fillSeats(int requiredSeats) {
        if(availableSeats() < requiredSeats || requiredSeats > this.seats.length) {
            return false;
        }
        for(int i = checkSeats(requiredSeats); i< requiredSeats; i++) {
            this.seats[i] = false;
        }
        return true;
    }

}
