public class Post{
    
    private int likes;
    private int comments;
    private int shares;
    private int reposts;
    private String type;
    private String uploadDate;
    private String user;
    private String caption;

    public Post(){
        this.likes = 0;
        this.comments = 0;
        this.shares = 0;
        this.reposts = 0;
        this.type = null;
        this.uploadDate = null;
        this.user = null;
        this.caption = null;
    }

    /**
     * Adds like to a certain post that you found
     * @param random
     * @return Post that was liked
     */
    public Post likePost(Post random){
        return null;
    }

    /**
     * Shares post to others along with adding to the share count on the original post
     * @param random
     * @return Post that was shared
     */
    public Post sharePost(Post random){
        return null;
    }

    /**
     * Reposts to your profile along with adding to the repost count on the original post
     * @param random
     * @return Post to your profile
     */
    public Post repostPost(Post random){
        return null;
    }

    /**
     * Takes the post that you found and adds the specific comment that you want underneath
     * that post
     * @param random
     * @param comment
     * @return Post with your comment underneath
     */
    public Post addComment(Post random, String comment){
        return null;
    }

    /**
     * Changes the type of post that you want to create to the
     * designated type that you listed
     * @param random
     * @param type
     * @return Post with the specific type you want
     */
    public Post changeType(Post random, String type){
        return null;
    }

    /**
     * Changes the caption on the selected post to 
     * the given caption
     * @param random
     * @param caption
     * @return Post with changed caption
     */
    public Post changeCaption(Post random, String caption){
        return null;
    }

    /**
     * Takes post from a user
     * @param random
     * @return user from who posted it in a String
     */
    public String postUser(Post random){
        return null;
    }

    /**
     * Takes a random post and returns the time and date that the post was uploaded on
     * @param random
     * @return Time of day and date
     */
    public Time postDate(Post random){
        return null;
    }


}