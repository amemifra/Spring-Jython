class CommonFunction:
    def importer(self, importer):
        try:
            import importer
        except ImportError as ie:
            print('Failed import:', ie)