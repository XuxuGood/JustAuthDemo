package me.zhyd.justauth.enums.scope;

import me.zhyd.oauth.enums.scope.AuthScope;

/**
 * @author xiaoxuxuy
 * @date 2022/11/15 14:20
 */
public enum AuthGithubScope implements AuthScope {

    REPO("repo", "Grants full access to public and private repositories including read and write access to code, commit statuses, repository invitations, collaborators, deployment statuses, and repository webhooks. Note: In addition to repository related resources, the repo scope also grants access to manage organization-owned resources including projects, invitations, team memberships and webhooks. This scope also grants the ability to manage projects owned by users.", false),
    REPO_STATUS("repo:status", "Grants read/write access to public and private repository commit statuses. This scope is only necessary to grant other users or services access to private repository commit statuses <em>without</em> granting access to the code.", false),
    ADMIN_REPO_HOOK("admin:repo_hook", "Grants read, write, ping, and delete access to repository hooks in public or private repositories. The repo and public_repo scopes grant full access to repositories, including repository hooks. Use the admin:repo_hook scope to limit access to only repository hooks.", false),
    WRITE_REPO_HOOK("write:repo_hook", "Grants read, write, and ping access to hooks in public or private repositories.", false),
    READ_REPO_HOOK("read:repo_hook", "Grants read and ping access to hooks in public or private repositories.", false),
    USER("user", "Grants read/write access to profile info only.  Note that this scope includes <code>user:email</code> and <code>user:follow</code>.", false);

    private final String scope;
    private final String description;
    private final boolean isDefault;

    @Override
    public String getScope() {
        return this.scope;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public boolean isDefault() {
        return this.isDefault;
    }

    private AuthGithubScope(String scope, String description, boolean isDefault) {
        this.scope = scope;
        this.description = description;
        this.isDefault = isDefault;
    }

}
