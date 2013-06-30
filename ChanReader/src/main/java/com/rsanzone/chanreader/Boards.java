package com.rsanzone.chanreader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thunaer on 6/29/13.
 */
public class Boards {
    private ArrayList<Board> boards;



    public Boards() {
        populateBoards();
    }

    private void populateBoards() {
        boards = new ArrayList<Board>();

        boards.add(new Board("3DCG", "/3/"));
        boards.add(new Board("Advice", "/adv/"));
        boards.add(new Board("Alternative sports", "/asp/"));
        boards.add(new Board("Animals & Nature", "/an/"));
        boards.add(new Board("Animated gif", "/gif/"));
        boards.add(new Board("Anime & Manga", "/a/"));
        boards.add(new Board("Anime/Cute", "/c/"));
        boards.add(new Board("Anime/Wallpapers", "/w/"));
        boards.add(new Board("Artwork/Critique", "/ic/"));
        boards.add(new Board("Auto", "/o/"));
        boards.add(new Board("Comics & Cartoons", "/co/"));
        boards.add(new Board("Cosplay & CGL", "/cgl/"));
        boards.add(new Board("Cute/Male", "/cm/"));
        boards.add(new Board("Discussion", "/q/"));
        boards.add(new Board("Do-It-Yourself", "/diy/"));
        boards.add(new Board("Ecchi", "/e/"));
        boards.add(new Board("Fashion", "/fa/"));
        boards.add(new Board("Food & Cooking", "/ck/"));
        boards.add(new Board("Graphic design", "/gd/"));
        boards.add(new Board("Handsome men", "/hm/"));
        boards.add(new Board("Hardcore", "/hc/"));
        boards.add(new Board("Health & Fitness", "/fit/"));
        boards.add(new Board("Hentai", "/h/"));
        boards.add(new Board("Hentai/Alternative", "/d/"));
        boards.add(new Board("High resolution", "/hr/"));
        boards.add(new Board("International", "/int/"));
        boards.add(new Board("LGBT", "/lgbt/"));
        boards.add(new Board("Literature", "/lit/"));
        boards.add(new Board("Mecha", "/m/"));
        boards.add(new Board("Music", "/mu/"));
        boards.add(new Board("Oekaki", "/i/"));
        boards.add(new Board("Otaku culture", "/jp/"));
        boards.add(new Board("Outdoors", "/out/"));
        boards.add(new Board("Papercraft & Origami", "/po/"));
        boards.add(new Board("Paranormal", "/x/"));
        boards.add(new Board("Photography", "/p/"));
        boards.add(new Board("Pokémon", "/vp/"));
        boards.add(new Board("Politically incorrect", "/pol/"));
        boards.add(new Board("Pony", "/mlp/"));
        boards.add(new Board("Random", "/b/"));
        boards.add(new Board("Request", "/r/"));
        boards.add(new Board("Retro games", "/vr/"));
        boards.add(new Board("Robot 9001", "/r9k/"));
        boards.add(new Board("Sexy beautiful women", "/s/"));
        boards.add(new Board("Shit 4chan says", "/s4s/"));
        boards.add(new Board("Social", "/soc/"));
        boards.add(new Board("Sports", "/sp/"));
        boards.add(new Board("Technology", "/g/"));
        boards.add(new Board("Television & Film", "/tv/"));
        boards.add(new Board("Torrents", "/t/"));
        boards.add(new Board("Toys", "/toy/"));
        boards.add(new Board("Traditional games", "/tg/"));
        boards.add(new Board("Transportation", "/n/"));
        boards.add(new Board("Travel", "/trv/"));
        boards.add(new Board("Video games", "/v/"));
        boards.add(new Board("Video games general", "/vg/"));
        boards.add(new Board("Wallpapers/General", "/wg/"));
        boards.add(new Board("Weapons", "/k/"));
        boards.add(new Board("Worksafe gif", "/wsg/"));
        boards.add(new Board("Yaoi", "/y/"));
        boards.add(new Board("Yuri", "/u/"));
    }
    public Board getBoard(String path) {
        return boards.get(boards.indexOf(new Board(path)));
    }



}
