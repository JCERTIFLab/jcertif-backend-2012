package com.jcertif.presentation.data.domain;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Details of a user of the MySchedule feature.
 */
public class MyScheduleUser {

    private String email;
    private String activationCode;
    private Set<Integer> favourites;
    private List<UserFavouritesChangedListener> listeners = new LinkedList<UserFavouritesChangedListener>();

    public MyScheduleUser(final String email, final String activationCode) {
        this.email = email;
        this.activationCode = activationCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(final String activationCode) {
        this.activationCode = activationCode;
    }

    public Set<Integer> getFavourites() {
        return favourites;
    }

    public void setFavourites(final Set<Integer> favourites) {
        this.favourites = favourites;
    }

    public void addFavourite(final JCertifPresentation presentation) {
        if (favourites == null) {
            favourites = new HashSet<Integer>();
        }
        boolean added = favourites.add(presentation.getId());
        if (added) {
            notifyListeners();
        }
    }

    public void removeFavourite(final JCertifPresentation presentation) {
        if (favourites != null) {
            // Must cast to Integer to avoid calling remove by index.
            boolean removed = favourites.remove((Integer) presentation.getId());
            if (removed) {
                notifyListeners();
            }
        }
    }

    public boolean hasFavourited(final JCertifPresentation presentation) {
        return favourites != null && favourites.contains(presentation.getId());
    }

    public void addListener(final UserFavouritesChangedListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    public void removeListener(final UserFavouritesChangedListener listener) {
        listeners.remove(listener);
    }

    /**
     * Notifies all listeners about a change in this user's favourites.
     */
    private void notifyListeners() {
        for (UserFavouritesChangedListener listener : listeners) {
            listener.favouritesChanged(this);
        }
    }

    public static interface UserFavouritesChangedListener {

        /**
         * Called when the favourites of a {@link MyScheduleUser} is changed.
         * 
         * @param user
         */
        void favouritesChanged(MyScheduleUser user);
    }
}
