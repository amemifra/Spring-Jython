class Main:
    def launchAndDebug(self, svnurl):
        stacktrace = 'Python stacktrace:'
        try:
            import svn.remote
            stacktrace = stacktrace + '\nsvnurl: \n' + svnurl
            r = svn.remote.RemoteClient(svnurl)
            stacktrace = stacktrace + '\n' + str(r.info())
        except (BaseException, Exception, ImportError, TypeError) as e:
            stacktrace = stacktrace + ' \n \n Custom Exception:\n' + str(e)
            print('Exception Handled')
        return stacktrace
